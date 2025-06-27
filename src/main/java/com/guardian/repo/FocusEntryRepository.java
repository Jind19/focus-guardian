package com.guardian.repo;

import com.guardian.model.FocusEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing FocusEntry entities.
 */

@Repository
public interface FocusEntryRepository extends CrudRepository<FocusEntry, Long> {
    // No additional methods required at this stage.
    // Spring Data JPA provides all basic CRUD functionality out of the box.
}
