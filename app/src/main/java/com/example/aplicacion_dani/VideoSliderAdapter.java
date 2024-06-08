package com.example.aplicacion_dani;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class VideoSliderAdapter extends RecyclerView.Adapter<VideoSliderAdapter.VideoViewHolder> {
    private List<String> videoIds;
    private Lifecycle lifecycle;
    private ViewPager2 viewPager;

    public VideoSliderAdapter(List<String> videoIds, Lifecycle lifecycle, ViewPager2 viewPager) {
        this.videoIds = videoIds;
        this.lifecycle = lifecycle;
        this.viewPager = viewPager;
    }

    public void setCurrentItem(int position) {
        viewPager.setCurrentItem(position);
    }
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_slider, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        String videoId = videoIds.get(position);
        holder.bindVideo(videoId);
    }

    @Override
    public int getItemCount() {
        return videoIds.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        private YouTubePlayerView playerView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            playerView = itemView.findViewById(R.id.youtube_player_view_slider);
            lifecycle.addObserver(playerView);
        }

        public void bindVideo(String videoId) {
            playerView.setEnableAutomaticInitialization(false);

            YouTubePlayerListener listener = new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    // using pre-made custom ui
                    DefaultPlayerUiController defaultPlayerUiController = new DefaultPlayerUiController(playerView, youTubePlayer);
                    playerView.setCustomPlayerUi(defaultPlayerUiController.getRootView());
                    defaultPlayerUiController.setFullscreenButtonClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openYouTubeApp(videoId);
                        }
                    });
                }
            };

            // disable iframe ui
            IFramePlayerOptions options = new IFramePlayerOptions.Builder().controls(0).build();
            playerView.initialize(listener, options);


            playerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });
        }
        private void openYouTubeApp(String videoId) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
                intent.putExtra("force_fullscreen", true);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                itemView.getContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                // YouTube app is not installed, open the video in the browser
                openYouTubeVideoInBrowser(videoId);
            }
        }

        private void openYouTubeVideoInBrowser(String videoId) {
            String videoUrl = "https://www.youtube.com/watch?v=" + videoId;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
            try {
                itemView.getContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(itemView.getContext(), "It's not possible open YouTube", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
