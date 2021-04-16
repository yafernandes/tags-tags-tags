# Tags

The intent of this application is to explore different ways of attaching tags to your deployments. The example is based on a Kubernetes deployment and expects the agent deployment configurations below.

```yaml
datadog:
  nodeLabelsAsTags:
    tags.ese.datadog.com/origem: origem
  podAnnotationsAsTags:
    tags.ese.datadog.com/origem: origem
  podLabelsAsTags:
    tags.ese.datadog.com/origem: origem
  tags:
    - origem:agent
```
