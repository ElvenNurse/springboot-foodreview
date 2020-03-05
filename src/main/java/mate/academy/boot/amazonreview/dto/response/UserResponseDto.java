package mate.academy.boot.amazonreview.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String userId;
    private String profileName;
    private Long reviewsCount;
}
