package com.group6.loyaltycard.api.user.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class RoutingDataSource extends AbstractRoutingDataSource {

    public static final String MASTER = "master";
    public static final String SLAVE = "slave";

    public RoutingDataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(MASTER, masterDataSource);
        targetDataSources.put(SLAVE, slaveDataSource);
        setTargetDataSources(targetDataSources);
        setDefaultTargetDataSource(masterDataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? SLAVE : MASTER;
    }
}


