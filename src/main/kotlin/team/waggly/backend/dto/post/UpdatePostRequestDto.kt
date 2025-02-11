package team.waggly.backend.dto.post

import org.springframework.web.multipart.MultipartFile
import team.waggly.backend.commomenum.CollegeType
import team.waggly.backend.model.Post
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdatePostRequestDto(
        @field:NotBlank
        val title: String?,

        @field:NotBlank
        val description: String?,

        @field:NotNull(message = "학부를 선택해주세요.")
        val college: CollegeType?,
        val file: List<MultipartFile>?,
        val deleteTargetUrl: List<String>?,
) {
    fun updateEntity(post: Post) {
        post.title = title ?: post.title
        post.description = description ?: post.description
        post.college = college ?: post.college
        post.modifiedAt = LocalDateTime.now()
    }
}
