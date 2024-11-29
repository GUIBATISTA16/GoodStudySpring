    package com.gooodstudy.goodstudyspring.security.model;

    import com.gooodstudy.goodstudyspring.model.Dados;
    import lombok.Getter;
    import lombok.Setter;
    import lombok.ToString;

    import java.io.Serializable;

    @Getter
    @Setter
    @ToString
    public class JwtResponse implements Serializable {

        private final String token;

        private final Dados utilizador;

        public JwtResponse(String jwttoken, Dados utilizador) {
            this.token = jwttoken;
            this.utilizador = utilizador;
        }


    }
