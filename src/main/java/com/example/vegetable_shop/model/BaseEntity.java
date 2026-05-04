package com.example.vegetable_shop.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public class BaseEntity {
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = createdDate != null ? createdDate : LocalDateTime.now();
        createdBy = "Mac Pham 01";
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            // Check if the principal is a UserDetails object (common in Spring Security)
//            if (authentication.getPrincipal() instanceof UserDetails userDetails) {
//                this.createBy = userDetails.getUsername();
//            } else if (authentication.getPrincipal() instanceof String) {
//                // Handle cases where the principal is a simple String (e.g., anonymousUser)
//                this.createBy = (String) authentication.getPrincipal();
//            }
//        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
        updatedBy = "Mac Pham 01";
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            // Check if the principal is a UserDetails object (common in Spring Security)
//            if (authentication.getPrincipal() instanceof UserDetails userDetails) {
//                this.updateBy = userDetails.getUsername();
//            } else if (authentication.getPrincipal() instanceof String) {
//                // Handle cases where the principal is a simple String (e.g., anonymousUser)
//                this.updateBy = (String) authentication.getPrincipal();
//            }
//        }
    }

}
