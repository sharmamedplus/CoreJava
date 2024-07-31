package com.java.designpatterns.builder;

public class User {

    public static void main(String[] args) {
        User build = new UserBuilder().setUserId("Vijay").setUserName("Sharma").build();
        System.out.println(build);
    }
    private final String userId;
    private final String userName;

    private User(UserBuilder userBuilder) {
        this.userId = userBuilder.getUserId();
        this.userName = userBuilder.getUserName();
    }

    static class UserBuilder {
        private String userId;
        private String userName;

        public UserBuilder(){}
        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }
        public String getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public User build(){
            User user = new User(this);
            return user;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
