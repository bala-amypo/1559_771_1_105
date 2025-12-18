// package com.example.demo.controller;

// import com.example.demo.dto.ApiResponse;
// import com.example.demo.dto.HostDTO;
// import com.example.demo.entity.Host;
// import com.example.demo.service.HostService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.stream.Collectors;

// @RestController
// @RequestMapping("/api/hosts")
// public class HostController {

//     private final HostService hostService;

//     public HostController(HostService hostService) {
//         this.hostService = hostService;
//     }

//     @PostMapping
//     public ResponseEntity<ApiResponse> createHost(@RequestBody HostDTO dto) {

//         Host host = new Host();
//         host.setHostName(dto.getHostName());
//         host.setEmail(dto.getEmail());
//         host.setDepartment(dto.getDepartment());
//         host.setPhone(dto.getPhone());

//         Host saved = hostService.createHost(host);

//         return new ResponseEntity<>(new ApiResponse(true, "Host created", toDto(saved)), HttpStatus.CREATED);
//     }

//     @GetMapping
//     public ResponseEntity<ApiResponse> getAll() {
//         List<HostDTO> list = hostService.getAllHosts()
//                 .stream().map(this::toDto).collect(Collectors.toList());
//         return ResponseEntity.ok(new ApiResponse(true, "Hosts fetched", list));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ApiResponse> getOne(@PathVariable Long id) {
//         Host host = hostService.getHost(id);
//         return ResponseEntity.ok(new ApiResponse(true, "Host fetched", toDto(host)));
//     }

//     private HostDTO toDto(Host h) {
//         HostDTO dto = new HostDTO();
//         dto.setId(h.getId());
//         dto.setHostName(h.getHostName());
//         dto.setEmail(h.getEmail());
//         dto.setDepartment(h.getDepartment());
//         dto.setPhone(h.getPhone());
//         return dto;
//     }
// }
