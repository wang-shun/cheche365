alter table channel_rebate_history add column `only_commercial_rebate` decimal(18,2) comment '预生效单商业险';
alter table channel_rebate_history add column `only_compulsory_rebate` decimal(18,2) comment '预生效单交强险';