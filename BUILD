java_library(
    name = "trace-lib",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "@vaticle_factory_tracing//client",
    ],
)

java_binary(
    name = "trace",
    runtime_deps = [":trace-lib"],
    main_class = "trace.Trace",
)