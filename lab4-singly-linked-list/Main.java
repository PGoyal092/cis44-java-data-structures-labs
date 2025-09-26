public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        playlist.addSong(new Song("Song A", "artist 1"));
        playlist.addSong(new Song("Song B", "artist 2"));
        playlist.addSong(new Song("Song C", "artist 3"));

        playlist.displayPlaylist();

        playlist.playNext(); // Song A
        playlist.playNext(); // Song B
        playlist.playNext(); // Song C
        playlist.playNext(); // Song A (loop)

        playlist.removeSong("Song B");
        playlist.displayPlaylist();

        playlist.playNext(); // Song C (if we were on Song A before)
    }
}