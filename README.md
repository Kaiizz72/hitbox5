# Bigger Player Hitbox (Fabric 1.21.1, Java 21)

- Tăng **hitbox người chơi** lên ~5% để PvP dễ hơn.
- Chỉ ảnh hưởng tới **PlayerEntity** (không ảnh hưởng mob khác).

## Build
1. Cài **Java 21**.
2. Cài **Gradle** (nếu không dùng gradle wrapper).
3. Mở terminal trong thư mục này:
   ```bash
   gradle build
   ```
   (hoặc `./gradlew build` nếu bạn tự thêm gradle wrapper)
4. Lấy file jar ở `build/libs/bigger-player-hitbox-1.0.0.jar` và bỏ vào thư mục `mods/` trên Fabric 1.21.1.

## Lưu ý
- Tăng ít (5%) để khó bị nhận ra. Bạn có thể đổi hệ số trong `PlayerHitboxMixin.java`.
