/// Response models for the Population Data API.

/// API Response wrapper.
class PopulationResponse {
  final String status;
  final dynamic error;
  final PopulationData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  PopulationResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory PopulationResponse.fromJson(Map<String, dynamic> json) => PopulationResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? PopulationData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Population Data API.

class PopulationData {
  String? country;
  String? countryName;
  num? year;
  num? count;
  List<PopulationDataHistoricalItem>? historical;

  PopulationData({
    this.country,
    this.countryName,
    this.year,
    this.count,
    this.historical,
  });

  factory PopulationData.fromJson(Map<String, dynamic> json) => PopulationData(
      country: json['country'],
      countryName: json['countryName'],
      year: json['year'],
      count: json['count'],
      historical: (json['historical'] as List?)?.map((e) => PopulationDataHistoricalItem.fromJson(e)).toList(),
    );
}

class PopulationDataHistoricalItem {
  num? year;
  num? population;
  String? populationFormatted;
  num? growthRate;
  num? urbanPercent;

  PopulationDataHistoricalItem({
    this.year,
    this.population,
    this.populationFormatted,
    this.growthRate,
    this.urbanPercent,
  });

  factory PopulationDataHistoricalItem.fromJson(Map<String, dynamic> json) => PopulationDataHistoricalItem(
      year: json['year'],
      population: json['population'],
      populationFormatted: json['populationFormatted'],
      growthRate: json['growthRate'],
      urbanPercent: json['urbanPercent'],
    );
}

class PopulationRequest {
  String country;
  int? year;

  PopulationRequest({
    required this.country,
    this.year,
  });

  Map<String, dynamic> toJson() => {
      'country': country,
      if (year != null) 'year': year,
    };
}
