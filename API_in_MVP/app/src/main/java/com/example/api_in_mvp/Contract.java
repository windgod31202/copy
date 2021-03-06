package com.example.api_in_mvp;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public interface Contract {
    public interface FakeAPIService{

        @GET ("/posts/id")
        presenter.Call<Post> getPost();
    }

    public interface presenter{
        public interface Call<T> extends Cloneable {
            /**
             * Synchronously send the request and return its response.
             *
             * @throws IOException if a problem occurred talking to the server.
             * @throws RuntimeException (and subclasses) if an unexpected error occurs creating the request
             * or decoding the response.
             */
            Response<T> execute() throws IOException;

            /**
             * Asynchronously send the request and notify {@code callback} of its response or if an error
             * occurred talking to the server, creating the request, or processing the response.
             */
            void enqueue(Callback<T> callback);

            /**
             * Returns true if this call has been either {@linkplain #execute() executed} or {@linkplain
             * #enqueue(Callback) enqueued}. It is an error to execute or enqueue a call more than once.
             */
            boolean isExecuted();

            /**
             * Cancel this call. An attempt will be made to cancel in-flight calls, and if the call has not
             * yet been executed it never will be.
             */
            void cancel();

            /** True if {@link #cancel()} was called. */
            boolean isCanceled();

            /**
             * Create a new, identical call to this one which can be enqueued or executed even if this call
             * has already been.
             */
            retrofit2.Call<T> clone();

            /** The original HTTP request. */
            Request request();
        }
        void callmode1();
    }

    public interface Model{

    }

    public interface View{
        void get();
    }

}
