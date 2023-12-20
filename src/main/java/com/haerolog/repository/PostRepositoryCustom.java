package com.haerolog.repository;

import com.haerolog.domain.Post;
import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(int page);

}
