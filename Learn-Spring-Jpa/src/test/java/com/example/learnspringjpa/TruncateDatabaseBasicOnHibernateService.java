package com.example.learnspringjpa;

import com.google.common.base.CaseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;

/**
 * Author saino
 * LastModify 7:48
 */
@Service
@Profile("test")
public class TruncateDatabaseBasicOnHibernateService {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Rollback(false)
    public void truncate() {
        List<EntityType<?>> tableEntities = new ArrayList<>();
        var hibernateMetamodel = entityManager.getMetamodel();

        tableEntities.addAll(hibernateMetamodel.getEntities());

        tableEntities.forEach(entity -> {
            //判断使用存在@Table重命名的表名
            var t = entity.getJavaType().getAnnotation(Table.class);
            var tableName = t == null ? entity.getName() : t.name().toUpperCase();
            if (tableName != null) {
                if (t == null) {
                    //tableName 驼峰转下划线
                    tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, tableName);
                }
                entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
                Query query = entityManager.createNativeQuery("TRUNCATE TABLE " + tableName);
                var result = query.executeUpdate();
                entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
            }
        });
    }

}
