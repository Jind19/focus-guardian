package com.guardian.web;

import com.guardian.model.FocusEntry;
import com.guardian.repo.FocusEntryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequestMapping("/focus")
@RestController
public class FocusEntryController {

    private final FocusEntryRepository repo;


    /**
     * Constructor-based dependency injection of repository
     */
    public FocusEntryController(FocusEntryRepository repo) {
        this.repo = repo;
    }

    /**
     * POST /focus
     * Creates a new focus entry.
     *
     * @param entry the entry provided by the client
     * @return the saved entry
     */
    @PostMapping
    public FocusEntry createEntry(@RequestBody FocusEntry entry){
        return repo.save(entry);
    }

    /**
     * GET /focus/{id}
     * Retrieves a single focus entry by ID.
     *
     * @param id the ID of the entry
     * @return an Optional containing the entry if found
     */
    @GetMapping("/{id}")
    public Optional<FocusEntry> getEntry(@PathVariable Long id){
        return repo.findById(id);
    }

    /**
     * GET /focus
     * Returns a list of all focus entries.
     *
     * @return all entries in the database
     */
    @GetMapping
    public Iterable<FocusEntry> listAllEntries() {
        return repo.findAll();
    }

    /**
     * GET /focus/stats
     * Returns basic statistics like total entries, successful entries, and success rate.
     *
     * @return a map containing the statistics
     */
    @GetMapping("/stats")
    public Map<String, Object> getStatus() {
        List<FocusEntry> entries = StreamSupport
                .stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());

        long total = entries.size();
        long success = entries.stream().filter(FocusEntry::getStatus).count();
        double rate = total == 0 ? 0.0 : (success * 100.0)/total;

        return Map.of(
                "totalEntries", total,
                "successfulEntries", success,
                "successRate", String.format("%.2f%%", rate)
        );
    }


}
