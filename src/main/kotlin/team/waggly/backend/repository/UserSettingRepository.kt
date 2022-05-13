package team.waggly.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.waggly.backend.model.UserSetting

interface UserSettingRepository : JpaRepository<UserSetting, Long> {
}