package com.lu.edu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHistoryEntity is a Querydsl query type for HistoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHistoryEntity extends EntityPathBase<HistoryEntity> {

    private static final long serialVersionUID = 859978684L;

    public static final QHistoryEntity historyEntity = new QHistoryEntity("historyEntity");

    public final StringPath adminname = createString("adminname");

    public final NumberPath<Integer> aid = createNumber("aid", Integer.class);

    public final StringPath begintime = createString("begintime");

    public final NumberPath<Integer> bid = createNumber("bid", Integer.class);

    public final StringPath bookname = createString("bookname");

    public final NumberPath<Integer> card = createNumber("card", Integer.class);

    public final StringPath endtime = createString("endtime");

    public final NumberPath<Integer> hid = createNumber("hid", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath username = createString("username");

    public QHistoryEntity(String variable) {
        super(HistoryEntity.class, forVariable(variable));
    }

    public QHistoryEntity(Path<? extends HistoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHistoryEntity(PathMetadata metadata) {
        super(HistoryEntity.class, metadata);
    }

}

