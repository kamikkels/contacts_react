INSERT INTO `Organisation`(`id`,`name`,`abn`) values (1, 'Australian Agent for International Students', 94887527583);
INSERT INTO `Organisation`(`id`,`name`,`abn`) values (2, 'CRP AUSTRALIA PTY LTD', 28606069890);
INSERT INTO `Organisation`(`id`,`name`,`abn`) values (3, 'THE AUSTRALIAN', 15145491676);

INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`organisation_id`,`created_on`) values (1, 'Sophie', 'Klein', 1, {ts '2021-09-17'});
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`organisation_id`,`created_on`) values (2, 'Perry', 'Kennedy', 1, {ts '2020-10-10'});
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`organisation_id`,`created_on`) values (3, 'Alma', 'Armstrong', 1, {ts '2021-01-01'});
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`organisation_id`,`created_on`) values (4, 'Alexander', 'Morris', 2, {ts '2021-02-02'});
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`organisation_id`,`created_on`) values (5, 'Wm', 'Brady', 2, {ts '2021-03-03'});
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`organisation_id`,`created_on`) values (6, 'Rudy', 'Bush', 2, {ts '2019-05-30'});
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`organisation_id`,`created_on`) values (7, 'Andres', 'Mcguire', 2, {ts '2017-04-07'});
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`organisation_id`,`created_on`) values (8, 'Nick', 'Lane', 3, {ts '2019-02-19'});