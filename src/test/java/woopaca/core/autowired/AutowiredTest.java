package woopaca.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import woopaca.core.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // @Autowired(required = false)
        @Autowired(required = false)
        public void setNoBeanByRequired(Member member) {
            System.out.println("@Autowired(required = false) = " + member);
        }

        // @Nullable
        @Autowired
        public void setNoBeanByNullable(@Nullable Member member) {
            System.out.println("@Nullable = " + member);
        }

        // Optional<>
        @Autowired
        public void setNoBeanByOptional(Optional<Member> member) {
            System.out.println("Optional<> = " + member);
        }
    }
}
