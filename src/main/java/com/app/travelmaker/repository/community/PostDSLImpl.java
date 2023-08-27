package com.app.travelmaker.repository.community;

import com.app.travelmaker.domain.community.PostDTO;
import com.app.travelmaker.entity.community.QCommunity;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.app.travelmaker.entity.community.QCommunity.community;

public class PostDSLImpl implements PostDSL {

    @Autowired
    private JPAQueryFactory query;


    @Override
    public List<PostDTO> getPostList(PostDTO postDTO) {


        return null;
    }

    @Override
    public Optional<PostDTO> detail(Long id) {

        Optional<PostDTO> foundPost = Optional.ofNullable(query.select(Projections.constructor(PostDTO.class,
                community.id,
                community.communityTitle,
                community.communityContent,
                community.communityCategory,
                community.createdDate,
                community.member.memberName,
                community.member.id
                )).from(community)
                .where(community.id.eq(id))
                .fetchOne());



        return foundPost;
    }

    @Override
    public void delete(Long id) {

    }
}
