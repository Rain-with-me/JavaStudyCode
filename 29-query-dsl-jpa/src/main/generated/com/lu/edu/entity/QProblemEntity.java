package com.lu.edu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProblemEntity is a Querydsl query type for ProblemEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProblemEntity extends EntityPathBase<ProblemEntity> {

    private static final long serialVersionUID = -304798329L;

    public static final QProblemEntity problemEntity = new QProblemEntity("problemEntity");

    public final NumberPath<Integer> aid = createNumber("aid", Integer.class);

    public final StringPath body = createString("body");

    public final StringPath name = createString("name");

    public final StringPath page = createString("page");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> pid = createNumber("pid", Integer.class);

    public final StringPath status = createString("status");

    public QProblemEntity(String variable) {
        super(ProblemEntity.class, forVariable(variable));
    }

    public QProblemEntity(Path<? extends ProblemEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProblemEntity(PathMetadata metadata) {
        super(ProblemEntity.class, metadata);
    }

}

