package it.bz.opendatahub.webcomponents.common.hibernate.usertype.impl;

import it.bz.opendatahub.webcomponents.common.hibernate.usertype.ListUserType;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public final class ListStringUserType extends ListUserType {
    public static final String NAME = "ListStringUserType";

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws SQLException {
        final String s = rs.getString(names[0]);

        if(s == null) {
            return null;
        }

        try {
            return Arrays.asList(objectMapper.readValue(s, String[].class));
        }
        catch (IOException e) {
            throw new HibernateException(e);
        }
    }
}
