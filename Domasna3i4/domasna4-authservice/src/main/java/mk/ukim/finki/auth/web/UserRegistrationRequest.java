package mk.ukim.finki.auth.web;

    public class UserRegistrationRequest {
        private String username;
        private String password;
        private String repeatPassword;
        private String email;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRepeatPassword() {
            return repeatPassword;
        }

        public String getEmail() {
            return email;
        }
    }
