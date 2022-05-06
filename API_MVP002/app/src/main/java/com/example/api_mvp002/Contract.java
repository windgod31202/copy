package com.example.api_mvp002;

public interface Contract {


    public interface Presenter {
        void getUser(int id);
    }

    public interface Model{
        void getUserInfo(int id, Callback callback);

        interface Callback {
            void onUserInfo(Post post);
        }
        static Repository getInstance() {
            return null;
        }
    }

    public interface View{
        void showUserInfo(Post post); //顯示使用者資訊
    }

}
