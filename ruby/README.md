# Population Data API - Ruby Gem

A country population and demographic data API. Look up any country by ISO code to get its population data, with total population, growth rate, density, urban/rural breakdown, and life expectancy on paid plans.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_population'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_population
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_population'

# Initialize the client
client = APIVerve::Population::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  country: "US",
  year: 2023
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ country: "US", year: 2023 })
  puts response["data"]
rescue APIVerve::Population::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Population::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Population::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/population?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/population?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/population?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
