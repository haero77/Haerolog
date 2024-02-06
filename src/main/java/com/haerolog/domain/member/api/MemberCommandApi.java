package com.haerolog.domain.member.api;

import com.haerolog.domain.member.api.request.MemberAppendRequest;
import com.haerolog.domain.member.service.MemberService;
import com.haerolog.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(MemberCommandApi.DEFAULT_URI_PREFIX)
@RequiredArgsConstructor
public class MemberCommandApi {

	public static final String DEFAULT_URI_PREFIX = "/api/v1/members";

	private final MemberService memberService;

	@PostMapping
	public ApiResponse<?> append(
			HttpServletResponse httpResponse,
			@RequestBody @Valid MemberAppendRequest request
	) {
		long newMemberId = memberService.append(request.toServiceRequest());
		return ApiResponse.created(httpResponse, toLocationUri(newMemberId));
	}

	private String toLocationUri(long memberId) {
		return DEFAULT_URI_PREFIX + String.format("/%d", memberId);
	}

}
