package practice11.exam04;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        PhotoAlbum photoAlbum = new PhotoAlbum();
        Consumer<Photo> consumer = System.out::println;

        System.out.println("[\uD83D\uDCF8 사진 촬영 중...]");
        photoAlbum.addPhoto(new Photo("지우", "브이✌️"), consumer);
        photoAlbum.addPhoto(new Photo("이슬이", "하트❤\uFE0F"), consumer);
        photoAlbum.addPhoto(new Photo("웅이", "메타몽 모자\uD83C\uDFA9️"), consumer);
        System.out.println();

        System.out.println("[\uD83D\uDCE4 SNS에 업로드된 사진 목록]");
        photoAlbum.printFiltered(photo -> photo.getPose().equalsIgnoreCase("하트❤\uFE0F"), consumer);

    }
}
