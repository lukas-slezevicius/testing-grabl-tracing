load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

def vaticle_dependencies():
    git_repository(
        name = "vaticle_dependencies",
        remote = "https://github.com/vaticle/dependencies",
        commit = "e3ba4970a3bb7db5e4725c0daa2a2a154ba9b3b8",  # sync-marker: do not remove this comment, this is used for sync-dependencies by @vaticle_dependencies
    )

def vaticle_factory_tracing():
    git_repository(
        name = "vaticle_factory_tracing",
        remote = "https://github.com/lukas-slezevicius/factory-tracing",
        commit = "dc65fe025944b9dd9b32c325648b4d61c517bb58"  # sync-marker: do not remove this comment, this is used for sync-dependencies by @vaticle_factory_tracing
    )