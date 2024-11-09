    package com.gooodstudy.goodstudyspring.security.model;

    import com.gooodstudy.goodstudyspring.model.Utilizador;
    import lombok.Getter;
    import lombok.Setter;
    import lombok.ToString;

    import java.io.Serializable;

    @Getter
    @Setter
    @ToString
    public class JwtResponse implements Serializable {

        private final String token;

        private final Utilizador utilizador;

        public JwtResponse(String jwttoken, Utilizador utilizador) {
            this.token = jwttoken;
            this.utilizador = utilizador;
        }


    }
