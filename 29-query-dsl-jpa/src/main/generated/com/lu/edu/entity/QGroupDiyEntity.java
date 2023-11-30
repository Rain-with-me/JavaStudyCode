package com.lu.edu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGroupDiyEntity is a Querydsl query type for GroupDiyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGroupDiyEntity extends EntityPathBase<GroupDiyEntity> {

    private static final long serialVersionUID = 1984502867L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGroupDiyEntity groupDiyEntity = new QGroupDiyEntity("groupDiyEntity");

    public final StringPath group_name = createString("group_name");

    public final StringPath id = createString("id");

    public final QUserDiyEntity userDiy;

    public QGroupDiyEntity(String variable) {
        this(GroupDiyEntity.class, forVariable(variable), INITS);
    }

    public QGroupDiyEntity(Path<? extends GroupDiyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGroupDiyEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGroupDiyEntity(PathMetadata metadata, PathInits inits) {
        this(GroupDiyEntity.class, metadata, inits);
    }

    public QGroupDiyEntity(Class<? extends GroupDiyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userDiy = inits.isInitialized("userDiy") ? new QUserDiyEntity(forProperty("userDiy")) : null;
    }

}

