package com.haerolog.repository;

import com.haerolog.domain.Post;
import com.haerolog.request.PostSearch;
import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);

}
