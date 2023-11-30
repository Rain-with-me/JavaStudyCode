package com.lu.edu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBooktypeEntity is a Querydsl query type for BooktypeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBooktypeEntity extends EntityPathBase<BooktypeEntity> {

    private static final long serialVersionUID = -1460111903L;

    public static final QBooktypeEntity booktypeEntity = new QBooktypeEntity("booktypeEntity");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> tid = createNumber("tid", Integer.class);

    public QBooktypeEntity(String variable) {
        super(BooktypeEntity.class, forVariable(variable));
    }

    public QBooktypeEntity(Path<? extends BooktypeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBooktypeEntity(PathMetadata metadata) {
        super(BooktypeEntity.class, metadata);
    }

}

