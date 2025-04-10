package kr.co.greenpai.oauth2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class Oauth2UserService  extends DefaultOAuth2UserService  {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        // OAuth 인층 업체(구글, 네이터, 카카오) 유저 정보 객체 반환
        log.info("userRequest={}", userRequest);

        String accessToken = userRequest.getClientRegistration().getClientId() + ":" + userRequest.getClientRegistration().getClientSecret();
        log.info("accessToken={}", accessToken);

        String provider = userRequest.getClientRegistration().getRegistrationId();
        log.info("provider={}", provider);

        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("oAuth2User={}", oAuth2User);

        return super.loadUser(userRequest);
    }

}
