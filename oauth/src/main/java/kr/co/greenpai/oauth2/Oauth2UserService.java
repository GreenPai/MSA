package kr.co.greenpai.oauth2;

import kr.co.greenpai.entity.User;
import kr.co.greenpai.repository.UserRepository;
import kr.co.greenpai.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class Oauth2UserService  extends DefaultOAuth2UserService  {

    private final UserRepository userRepository;

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

        Map<String, Object> attrs = oAuth2User.getAttributes();

        String email = (String) attrs.get("email");
        String uid = email.substring(0, email.lastIndexOf("@"));
        String name = (String) attrs.get("name");

        // 회원 테이블에서 사용자 확인
        Optional<User> optUser = userRepository.findById(uid);

        if(optUser.isPresent()){
            // 회원이 존재하지 않으면 정보를 저장
            User user = User.builder()
                    .uid(uid)
                    .name(name)
                    .role("USER")
                    .provider(provider)
                    .build();

            userRepository.save(user);

        }

        User user = optUser.get();

        return MyUserDetails.builder()
                .user(user)
                .attributes(attrs)
                .accessToken(accessToken)
                .build();

    }

}
