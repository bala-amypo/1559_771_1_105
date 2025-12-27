// package com.example.demo.controller;

// import com.example.demo.model.Host;
// import com.example.demo.service.HostService;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/hosts")
// public class HostController {

//     private final HostService hostService;

//     public HostController(HostService hostService) {
//         this.hostService = hostService;
//     }

//     @PostMapping
//     public Host createHost(@RequestBody Host host) {
//         return hostService.createHost(host);
//     }

//     @GetMapping("/{id}")
//     public Host getHost(@PathVariable Long id) {
//         return hostService.getHost(id);
//     }

//     @GetMapping
//     public List<Host> getAllHosts() {
//         return hostService.getAllHosts();
//     }

//     @DeleteMapping("/{id}")
//     public String deleteHost(@PathVariable Long id) {
//         hostService.deleteHost(id);
//         return "Host deleted successfully";
//     }
// }
