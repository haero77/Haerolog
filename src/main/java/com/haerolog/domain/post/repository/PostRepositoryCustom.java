package com.haerolog.domain.post.repository;

import com.haerolog.domain.Post;
import com.haerolog.domain.post.service.request.PostSearch;
import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);

}
