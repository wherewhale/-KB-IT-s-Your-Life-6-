package practice06.problem05;

public class PlaybackLogger {
    void log(String title, String artist) {
        class RecentLog {
            String title;
            String artist;

            RecentLog(String title, String artist) {
                this.title = title;
                this.artist = artist;
            }

            void printLog() {
                String result = "🎼 최근 재생: " + title + " - " + artist;
                if (title.length() >= 10 || artist.length() >= 10) {
                    result += " (인기곡)";
                }
                System.out.println(result);
            }
        }
        //log() 메서드는 RecentLog의 인스턴스를 생성하고, printLog()를 호출하여 출력한다.

        RecentLog recentLog = new RecentLog(title, artist);
        recentLog.printLog();
    }
}
