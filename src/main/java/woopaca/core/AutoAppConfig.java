package woopaca.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import woopaca.core.member.MemberRepository;
import woopaca.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION, classes = Configuration.class
        )
)
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
