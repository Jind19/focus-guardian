package com.guardian.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entity representing a focus entry record in the database.
 * Each entry captures a reason for focus, its current status, and the timestamp of creation.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor // constructor for required (non-null) fields
@Entity
@Table(name = "focus_entry")
public class FocusEntry {

    // ------- Fields -------
    /**
     * The unique identifier for this focus entry.
     * It is automatically generated when the entity is persisted.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * The reason associated with this focus entry.
     * This field captures the purpose or context of focus.
     */
    @NonNull
    @Column(name = "reason", nullable = false)
    private String reason;

    /**
     * The status of the focus entry.
     * Typically used to indicate whether the focus reason is active (true) or completed/inactive (false).
     */
    @NonNull
    @Column(name = "status", nullable = false)
    private Boolean status;

    /**
     * The timestamp indicating when this focus entry was created.
     * Stored as a LocalDateTime.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Automatically sets the creation timestamp before the entity is persisted.
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
