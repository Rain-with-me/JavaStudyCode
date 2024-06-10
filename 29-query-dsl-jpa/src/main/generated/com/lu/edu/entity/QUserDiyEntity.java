package com.lu.edu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserDiyEntity is a Querydsl query type for UserDiyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserDiyEntity extends EntityPathBase<UserDiyEntity> {

    private static final long serialVersionUID = 22815793L;

    public static final QUserDiyEntity userDiyEntity = new QUserDiyEntity("userDiyEntity");

    public final StringPath email = createString("email");

    public final ListPath<GroupDiyEntity, QGroupDiyEntity> groupDiys = this.<GroupDiyEntity, QGroupDiyEntity>createList("groupDiys", GroupDiyEntity.class, QGroupDiyEntity.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final EnumPath<UserDiyEntity.Gender> sex = createEnum("sex", UserDiyEntity.Gender.class);

    public final StringPath username = createString("username");

    public QUserDiyEntity(String variable) {
        super(UserDiyEntity.class, forVariable(variable));
    }

    public QUserDiyEntity(Path<? extends UserDiyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserDiyEntity(PathMetadata metadata) {
        super(UserDiyEntity.class, metadata);
    }

}

