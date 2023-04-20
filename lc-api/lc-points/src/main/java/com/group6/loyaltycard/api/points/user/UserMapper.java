package com.group6.loyaltycard.api.points.user;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User WHERE userId = #{userId}")
    User findById(@Param("userId") Integer userId);

    @Select("SELECT * FROM User")
    List<User> findAll();

    @Insert("INSERT INTO User (userName, email, cardId, region, regionName) VALUES (#{userName}, #{email}, #{cardId}, #{region}, #{regionName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "userId")
    int insert(User user);

    @Update("UPDATE User SET userName = #{userName}, email = #{email}, cardId = #{cardId}, region = #{region}, regionName = #{regionName} WHERE userId = #{userId}")
    int update(User user);

    @Delete("DELETE FROM User WHERE userId = #{userId}")
    int delete(@Param("userId") Integer userId);

    class User {
        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        private Integer userId;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getCardId() {
            return cardId;
        }

        public void setCardId(Integer cardId) {
            this.cardId = cardId;
        }

        public Integer getRegion() {
            return region;
        }

        public void setRegion(Integer region) {
            this.region = region;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        private String userName;
        private String email;
        private Integer cardId;
        private Integer region;
        private String regionName;
    }
}