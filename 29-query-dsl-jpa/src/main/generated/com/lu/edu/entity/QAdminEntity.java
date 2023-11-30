package com.lu.edu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminEntity is a Querydsl query type for AdminEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminEntity extends EntityPathBase<AdminEntity> {

    private static final long serialVersionUID = 593258359L;

    public static final QAdminEntity adminEntity = new QAdminEntity("adminEntity");

    public final NumberPath<Integer> aid = createNumber("aid", Integer.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> lendNum = createNumber("lendNum", Integer.class);

    public final NumberPath<Integer> maxNum = createNumber("maxNum", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Integer> times = createNumber("times", Integer.class);

    public final StringPath username = createString("username");

    public QAdminEntity(String variable) {
        super(AdminEntity.class, forVariable(variable));
    }

    public QAdminEntity(Path<? extends AdminEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminEntity(PathMetadata metadata) {
        super(AdminEntity.class, metadata);
    }

}

