package com.example.instagramclone.fragments;

import android.util.Log;

import com.example.instagramclone.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment {

    private static final String TAG = "ProfileFragment";

    @Override
    protected void queryPosts() {
        super.queryPosts();

        // Specify which class to query
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);

        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());

        // Limit to max 20 posts per page
        query.setLimit(20);

        // want to set most recent content
        query.addDescendingOrder(Post.KEY_CREATED_DATE);

        // Execute the find asynchronously
        query.findInBackground(new FindCallback<Post>() {

            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }



                // iterate through all posts and display the description of the post
                for (Post post: posts){
                    Log.i(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
                }
                allPosts.addAll(posts); // make sure no naming collision between allPosts and posts
                adapter.notifyDataSetChanged();
            }
        });
    }
}
