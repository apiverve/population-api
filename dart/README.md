# Population Data API - Dart/Flutter Client

A country population and demographic data API. Look up any country by ISO code to get its population data, with total population, world population rank and share, growth rate, density, urban/rural breakdown, and life expectancy on paid plans.

[![pub package](https://img.shields.io/pub/v/apiverve_population.svg)](https://pub.dev/packages/apiverve_population)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Population Data API](https://apiverve.com/marketplace/population?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_population: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_population/apiverve_population.dart';

void main() async {
  final client = PopulationClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'country': 'US',
      'year': 2023
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Population Data API](https://apiverve.com/marketplace/population?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/population](https://docs.apiverve.com/ref/population?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
