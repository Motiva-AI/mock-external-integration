# mock-external-integration

A mock API for integrating with Motiva. This repository is deployed to
[https://motiva-mock.herokuapp.com](https://motiva-mock.herokuapp.com).

[API doc](https://motiva-mock.herokuapp.com) | [One-pager integration doc](https://docs.google.com/document/d/10r5vizs1PBMFOLZJ1RvJA0MbxVqC6wBGtrS1zXpX3T8)

## Usage

### Deployment

This repository is linked to our CI platform for continuous integration and
deployment. The latest `master` commit that passes is deployed to Heroku automatically.

Some environment variables will need to be set. See `Environment Variables` section.

#### Environment Variables

- `GATEWAY_HOSTNAME`, hostname of the gateway server that this app will be using, e.g. `https://api.example.com` (no trailing slash)

### Local Development

```
$ lein ring server
```

## Contact

[Paul Lam](paul@motiva.ai)

## License

Copyright © 2017 Motiva

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
