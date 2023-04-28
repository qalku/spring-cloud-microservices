CREATE TABLE APP (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    instanceId VARCHAR(200) NULL,
    hostName VARCHAR(100) NULL,
    app VARCHAR(100) NULL,
    ipAddr VARCHAR(64) NULL,
    status VARCHAR(100) NULL,
    overriddenstatus VARCHAR(100) NULL,
    port INTEGER DEFAULT(0) NOT NULL,
    secureport INTEGER DEFAULT(0) NOT NULL,
    countryId INTEGER DEFAULT(1) NOT NULL,
    homePageUrl VARCHAR(200) NULL,
    statusPageUrl VARCHAR(200) NULL,
    healthCheckUrl VARCHAR(200) NULL,
    vipAddress VARCHAR(100) NULL,
    secureVipAddress VARCHAR(100) NULL,
    isCoordinatingDiscoveryServer VARCHAR(20) NULL,
    actionType VARCHAR(20) NULL,

    databaseOn INTEGER DEFAULT(0) NOT NULL,
    databaseViewOn INTEGER DEFAULT(0) NOT NULL,
    databaseType VARCHAR(100) NULL,
    databaseAddress VARCHAR(200) NULL,
    databaseUser VARCHAR(200) NULL,
    databaseConsole VARCHAR(200) NULL,

    swaggerApiOn INTEGER DEFAULT(0) NOT NULL,

    created timestamp
);