// package com.app.demo.repository;

// import java.util.List;

// import org.springframework.context.annotation.Bean;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

// import com.app.demo.model.User;



// @Repository
// public interface UserRepo extends JpaRepository<User, Integer> {

//     User findByEmail(String email);

//     User findByResetPasswordToken(String token);

//     @Modifying
//     @Transactional
//     @Query("UPDATE User u SET u.email=?1, u.firstName=?2, u.lastName=?3, u.gender=?4, u.contactNo=?5, u.address=?6, u.role=?7 WHERE u.id=?8")
//     void updateUser(String email, String firstName, String lastName, String gender, String contactno, String address, String role, int id);

//     @Modifying
//     @Transactional
//     @Query("UPDATE User u SET u.email=?1, u.firstName=?2, u.lastName=?3, u.gender=?4, u.contactNo=?5, u.address=?6, u.role=?7, u.password=?8, u.confirmPassword=?9 WHERE u.id=?10")
//     void updateUserpro(String email, String firstName, String lastName, String gender, String contactno, String address, String role, String password, String cpassword, int id);

//     @Query("SELECT u FROM User u WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1% OR u.email LIKE %?1% OR u.contactNo LIKE %?1% OR u.gender LIKE %?1% OR u.role LIKE %?1%")
//     List<User> findByKey(String searchkey);

//     @Query("SELECT u FROM User u WHERE u.role = ?1")
//     User findByRole(String role);

//     @Query("SELECT COUNT(u) FROM User u WHERE u.role=?1")
//     long countByRole(String role);
// }


package com.app.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByResetPasswordToken(String token);

    @Modifying
    @Transactional
    @Query(
        "UPDATE User u SET " +
        "u.email = ?1, " +
        "u.firstName = ?2, " +
        "u.lastName = ?3, " +
        "u.gender = ?4, " +
        "u.contactno = ?5, " +   // ✅ FIXED
        "u.address = ?6, " +
        "u.role = ?7 " +
        "WHERE u.id = ?8"
    )
    void updateUser(
        String email,
        String firstName,
        String lastName,
        String gender,
        String contactno,
        String address,
        String role,
        int id
    );

    @Modifying
    @Transactional
    @Query(
        "UPDATE User u SET " +
        "u.email = ?1, " +
        "u.firstName = ?2, " +
        "u.lastName = ?3, " +
        "u.gender = ?4, " +
        "u.contactno = ?5, " +   // ✅ FIXED
        "u.address = ?6, " +
        "u.role = ?7, " +
        "u.password = ?8, " +
        "u.confirmPassword = ?9 " +
        "WHERE u.id = ?10"
    )
    void updateUserpro(
        String email,
        String firstName,
        String lastName,
        String gender,
        String contactno,
        String address,
        String role,
        String password,
        String confirmPassword,
        int id
    );

    @Query(
        "SELECT u FROM User u " +
        "WHERE u.firstName LIKE %?1% " +
        "OR u.lastName LIKE %?1% " +
        "OR u.email LIKE %?1% " +
        "OR u.contactno LIKE %?1% " +  // ✅ FIXED
        "OR u.gender LIKE %?1% " +
        "OR u.role LIKE %?1%"
    )
    List<User> findByKey(String searchkey);

    @Query("SELECT u FROM User u WHERE u.role = ?1")
    User findByRole(String role);

    @Query("SELECT COUNT(u) FROM User u WHERE u.role = ?1")
    long countByRole(String role);
}

