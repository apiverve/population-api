# Population Data API - PHP Package

A country population and demographic data API. Look up any country by ISO code to get its population data, with total population, growth rate, density, urban/rural breakdown, and life expectancy on paid plans.

## Installation

Install via Composer:

```bash
composer require apiverve/population
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Population\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'country' => 'US',
    'year' => 2023
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Population\Client;
use APIVerve\Population\Exceptions\APIException;
use APIVerve\Population\Exceptions\ValidationException;

try {
    $response = $client->execute(['country' => 'US', 'year' => 2023]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "country": "US",
    "countryName": "United States",
    "year": 2025,
    "count": 1,
    "historical": [
      {
        "year": 2025,
        "population": 341784857,
        "populationFormatted": "341.78 million",
        "growthRate": 0.52,
        "urbanPercent": 80.19
      }
    ]
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/population?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/population?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/population?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
