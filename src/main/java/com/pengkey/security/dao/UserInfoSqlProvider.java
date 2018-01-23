package com.pengkey.security.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.pengkey.security.domain.UserInfo;
import com.pengkey.security.domain.UserInfoExample.Criteria;
import com.pengkey.security.domain.UserInfoExample.Criterion;
import com.pengkey.security.domain.UserInfoExample;
import java.util.List;
import java.util.Map;

public class UserInfoSqlProvider {

    public String countByExample(UserInfoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("user_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(UserInfoExample example) {
        BEGIN();
        DELETE_FROM("user_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(UserInfo record) {
        BEGIN();
        INSERT_INTO("user_info");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserMobile() != null) {
            VALUES("user_mobile", "#{userMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            VALUES("user_sex", "#{userSex,jdbcType=INTEGER}");
        }
        
        if (record.getUserAge() != null) {
            VALUES("user_age", "#{userAge,jdbcType=INTEGER}");
        }
        
        if (record.getUserAdress() != null) {
            VALUES("user_adress", "#{userAdress,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(UserInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("user_id");
        } else {
            SELECT("user_id");
        }
        SELECT("user_name");
        SELECT("user_mobile");
        SELECT("user_sex");
        SELECT("user_age");
        SELECT("user_adress");
        FROM("user_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserInfo record = (UserInfo) parameter.get("record");
        UserInfoExample example = (UserInfoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("user_info");
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserMobile() != null) {
            SET("user_mobile = #{record.userMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            SET("user_sex = #{record.userSex,jdbcType=INTEGER}");
        }
        
        if (record.getUserAge() != null) {
            SET("user_age = #{record.userAge,jdbcType=INTEGER}");
        }
        
        if (record.getUserAdress() != null) {
            SET("user_adress = #{record.userAdress,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("user_info");
        
        SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("user_mobile = #{record.userMobile,jdbcType=VARCHAR}");
        SET("user_sex = #{record.userSex,jdbcType=INTEGER}");
        SET("user_age = #{record.userAge,jdbcType=INTEGER}");
        SET("user_adress = #{record.userAdress,jdbcType=VARCHAR}");
        
        UserInfoExample example = (UserInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserInfo record) {
        BEGIN();
        UPDATE("user_info");
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserMobile() != null) {
            SET("user_mobile = #{userMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            SET("user_sex = #{userSex,jdbcType=INTEGER}");
        }
        
        if (record.getUserAge() != null) {
            SET("user_age = #{userAge,jdbcType=INTEGER}");
        }
        
        if (record.getUserAdress() != null) {
            SET("user_adress = #{userAdress,jdbcType=VARCHAR}");
        }
        
        WHERE("user_id = #{userId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(UserInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}