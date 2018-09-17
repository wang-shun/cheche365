// Register Status Listener
statusListener OnConsoleStatusListener


// Settings
def port = System.getProperty 'server.port'
println "$hostname:$port"

def otherAppenders  = ['console', 'otherDailyRollingFile']
def appAppenders    = ['console', 'appDailyRollingFile']

def commonAppenderNames = [
    'other',
    'app'
]
def individualAppenderNames = [
    'pushmessage'
]

def patternLayout = '[USER:%X{user}] [DEVICE:%X{deviceType}] [SESSIONID:%X{sessionId}] [IP:%X{ip}] %d{HH:mm:ss.SSS} [%thread] %-5level %logger{60} - %msg %n'

// To prevent the ID displaying complication error
def forcefullyDisableProductionEnv      = Boolean.valueOf System.getProperty('logback.forcefully.disable.production.env', Boolean.FALSE.toString())

def productionEnv           = forcefullyDisableProductionEnv ? false : ('production' == System.getProperty('spring.profiles.active'))
def identify = { hostname ->
    productionEnv ?
        "/data/nfs0/logs/pushmessage/$hostname/$port"       // nfs0
        : (('/data/nfs2' as File).exists() ?
            "/data/nfs2/logs/pushmessage/$hostname/$port"   // nfs2
            : 'logs')                                       // local
}
def logFilePathPrefix       = productionEnv ?
                                // production
                                identify(hostname)
                                // non-production
                                : ('build' as File).exists() ?
                                    'build/logs'        // ide
                                    // other profiles
                                    : identify(hostname)

def maxLogArchiveHistoryDays = 180


// Appenders
appender('console', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}

(commonAppenderNames + individualAppenderNames).each { name ->
    createAppender name, logFilePathPrefix, maxLogArchiveHistoryDays, patternLayout
}


/**
 * Loggers
 * ROOT：other.log文件，每天归档，在产品环境下不会向console输出
 * 其他：写入app.log文件，每天归档，cheche包下的全用DEBUG级别，其他同上
 */
root productionEnv ? WARN : INFO, productionEnv ? otherAppenders - 'console' : otherAppenders

// internal
logger 'com.cheche365.cheche', DEBUG, productionEnv ? appAppenders - 'console' : appAppenders, false


individualAppenderNames.each { name ->
    logger "com.cheche365.cheche.$name", DEBUG, ["${name}DailyRollingFile"]
}

logger 'com.cheche365.cheche.common', productionEnv ? WARN : INFO

// external
externalCategories.each { category ->
    logger category, DEBUG, productionEnv ? appAppenders - 'console' : appAppenders, false
}




private void createAppender(name, logFilePathPrefix, maxLogArchiveHistoryDays, patternLayout) {
    appender("${name}DailyRollingFile", RollingFileAppender) {
        file = "$logFilePathPrefix/${name}.log"
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "$logFilePathPrefix/${name}.%d{yyyy-MM-dd}.gz"
            maxHistory = maxLogArchiveHistoryDays
        }
        encoder(PatternLayoutEncoder) {
            pattern = patternLayout
        }
    }
}
